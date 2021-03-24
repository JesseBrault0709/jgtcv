package com.brault.jgtcv.api.builder;

import com.brault.jgtcv.api.model.CV;
import com.brault.jgtcv.api.model.CVSection;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The main builder for the CV. CV base scripts (not the user scripts) should either delegate to an instance
 * of this class, or have a "cv" method whose closure delegates to an instance of this class.
 */
public interface CVBuilder {

    /**
     * Finds and returns an implementation of this interface.
     */
    static Optional<CVBuilder> getImplementation() {
        final Logger logger = LogManager.getLogger();

        logger.traceEntry();

        try (final ScanResult scan = new ClassGraph().enableClassInfo().scan()) {
            final ClassInfoList cvBuilderClasses = scan.getClassesImplementing(CVBuilder.class.getName());

            final List<CVBuilder> allCVBuilders = cvBuilderClasses.stream()
                    .<Optional<CVBuilder>>map(classInfo -> {
                        final Class<?> builderClass = classInfo.loadClass();
                        try {
                            final Constructor<?> constructor = builderClass.getConstructor(); // no-args
                            final Object builder = constructor.newInstance();
                            if (builder instanceof CVBuilder) {
                                return Optional.of((CVBuilder) builder);
                            } else {
                                logger.warn("instance returned by constructor for class {} is not an instance of CVBuilder", builderClass.getName());
                            }
                        } catch (NoSuchMethodException e) {
                            logger.catching(Level.WARN, e);
                            logger.warn("CVBuilder class {} does not have a no-args constructor; see stacktrace above", builderClass.getName());
                        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                            logger.catching(Level.WARN, e);
                            logger.warn("exception while instantiating CVBuilder class {}; see stacktrace above", builderClass.getName());
                        }
                        return Optional.empty();
                    })
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            if (allCVBuilders.size() == 0) {
                logger.warn("no CVBuilders found!");
                return logger.traceExit(Optional.empty());
            } else if (allCVBuilders.size() > 1) {
                logger.warn("found more than one CVBuilder! check your classpath and that you don't have conflicting plugins");
                return logger.traceExit(Optional.empty());
            } else {
                return logger.traceExit(Optional.of(allCVBuilders.get(0)));
            }

        }
    }

    CVBuilder section(CVSection section);
    CVBuilder sections(Collection<? extends CVSection> sections);
    CV build();

}
