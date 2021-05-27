import com.brault.jgtcv.api.script.CVScript
import groovy.transform.BaseScript

@BaseScript
CVScript base

cv {
    heading {
        name 'Jesse Brault'
        professionalTitle 'Java Programmer'
    }

    experience {
        sectionName 'Projects'

        exp {
            institution 'JgtCV (Java-Groovy-TeX Curriculum Vitae)'
            description "Developed a command line utility for easing development and maintenance of beautiful resumes and curriculum vitae."
            date month: 'March', year: 2021

            duties {
                duty "Created a Groovy DSL for inputting resume/CV data."
                duty "Implemented a basic TeX macro set for resume/CV output."
            }
        }
    }

    education {
        degree {
            institution 'St. Olaf College'
            degreeName 'Bachelor of Music'
            gpa '3.91'
            dates {
                start year: 2009
                end year: 2013
            }
            relevantCoursework {
                course 'Computer Science I'
            }
        }
        degree {
            institution 'The Juilliard School'
            degreeName 'Master of Music'
            dates {
                start year: 2015
                end year: 2018
            }
        }
    }

}
