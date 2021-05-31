import groovy.transform.BaseScript
import com.brault.jgtcv.api.script.CVScript

@BaseScript
CVScript base

cv {
    heading {
        name 'Jesse Brault'
        professionalTitle 'Conductor and Composer'
        documentTitle 'Curriculum Vitae'
    }

    education {

        musicDegree {
            institution 'St. Olaf College'
            degreeName 'Bachelor of Music'
            major 'Theory and Composition'
            gpa '3.91'

            dates {
                start year: 2009
                end year: 2013
            }

            privateTeachers(["Steven Amundson", "Timothy Mahr", "Justin Merritt"])

            relevantCoursework {
                course 'composition'
                course 'theory'
                course 'conducting'
                course 'music history'
                course 'counterpoint'
            }
        }

        musicDegree {
            institution 'The Juilliard School'
            degreeName 'Master of Music'
            major 'Orchestral Conducting'

            dates {
                start year: 2015
                end year: 2018
            }

            privateTeacher 'Alan Gilbert'
            privateTeacher 'James Ross'

            relevantCoursework {
                course 'conducting'
                course 'score reading'
                course 'counterpoint'
                course 'harmony'
                course 'music history'
            }
        }

    }

    positions {

        sectionName 'Conducting Positions'

        position {
            institution 'Red Dog Ensemble'
            role 'Co-founder and conductor.'

            dates {
                start year: 2019
            }

            duties {

                presentTense true

                duty 'Conducting all rehearsals and performances'
                duty 'Working closely with composers of new works'
                duty 'Planing and leading recording sessions'
                duty 'Communicating with ensemble members'
                duty 'Long-term planning and fundraising'
            }
        }

        position {
            institution 'Fordham University Lincoln Center Chamber Orchestra'
            role 'Professor and conductor.'

            dates {
                start year: 2018
                end year: 2019
            }

            duties {
                duty 'Leading weekly rehearsals'
                duty 'Auditioning students for seating and to determine individual ability'
                duty 'Choosing repertoire that would be both engaging and enjoyable'
                duty 'Bringing in outside professional musicians to coach the students'
                duty 'Working with administration to plan concerts, student recruiting, etc.'
            }

        }
    }

    experience {

        sectionName 'Conducting Experience'

        musicExp {
            institution 'Boston Symphony Orchestra'
            role 'Cover conductor for Yuan Chang.'

            date month: 'January', year: 2020

            works {
                work composer: 'Chihchun Chi-sun Lee', title: 'Formosan Triptych', italicized: true
                work composer: 'Mozart', title: 'Piano concerto no. 25'
                work composer: 'Tchaikovsky', title: 'Symphony no. 3'
            }

        }

        musicExp {
            institution 'New Jersey Symphony Orchestra'
            role 'Cover conductor for Xian Zhang.'
            date month: 'December', year: 2019

            works {
                work composer: 'Anna Clyne', title: 'Within Her Arms', italicized: true
                work composer: 'Rachmaninov', title: 'Piano concerto no. 3'
                work composer: 'Dvořák', title: 'Symphony no. 8'
            }
        }

        musicExp {
            institution 'St. Louis Symphony Orchestra'
            role 'Cover conductor for Andrew Grams.'
            date month: 'November', year: 2019

            works {
                work composer: 'Tchaikovsky', title: 'The Nutcracker', italicized: true
            }
        }

        musicalWorkExp {
            work composer: 'Josh Getman', title: 'Oedipus in the District', italicized: true
            date month: 'October', year: 2019
            description 'Music director for a contemporary one-act opera performed twice at The Tank, New York, NY.'
        }

        musicExp {
            institution 'Red Dog Ensemble'
            role 'Conductor and co-founder.'
            description 'Recorded an album at Avaloch Farm Institute, Boscawen, New Hampshire.'
            date month: 'October', year: 2019

            works {
                work composer: 'Jon Cziner', title: 'flowers of fire', italicized: true
                work composer: 'Sato Matsui', title: 'The Imperfect Storm', italicized: true
                work composer: 'Tom Morrison', title: 'Neon and Oak', italicized: true
                work composer: 'Will Stackpole', title: "L'abîme", italicized: true
            }
        }

        musicExp {
            institution 'Juilliard Pre-College Symphony'
            role 'Assistant conductor for James Ross.'
            date month: 'September', year: 2019

            works {
                work composer: 'Boulanger', title: "D'un soir triste", italicized: true
                work composer: 'Bruch', title: 'Violin Concerto', italicized: true
                work composer: 'Thompson', title: 'Symphony no. 2'
            }
        }

        musicExp {
            institution 'Fordham University Lincoln Center Chamber Orchestra'
            role 'Professor and conductor.'
            description 'Spring semester culminating performance.'
            date month: 'April', year: 2019

            works {
                work composer: 'Beethoven', title: 'Symphony no. 6'
                work composer: 'Bartók', title: 'Romanian Folk Dances', italicized: true
            }
        }

        exp {
            institution 'Nord Anglia Performing Arts Festival'
            role 'Guest conductor.'
            date month: 'March', year: 2019

            duties {
                duty 'Programing music for two youth orchestras (ages 10--18) and a combined orchestra/chorus work'
                duty 'Preparing parts for distribution to students in advance of festival'
                duty 'Working closely with festival staff during planning and execution stages'
                duty 'Leading and conducting all rehearsals and final concert'
            }
        }

        exp {
            institution 'Juilliard Pre-College Orchestra'
            role 'Rehearsal guest conductor.'
            date month: 'March', year: 2019
            description 'Reading of four new student works for orchestra.'
        }

        musicExp {
            institution 'Juilliard Pre-College Symphony'
            role 'Rehearsal guest conductor.'
            date month: 'March', year: 2019

            works {
                work composer: 'de Falla', title: 'Three-Cornered Hat Suite', italicized: true
                work composer: 'Mendelssohn', title: 'Symphony no. 3'
            }
        }

        musicExp {
            institution 'Ensemble Connect'
            role 'Guest conductor.'
            date month: 'February', year: 2019

            works {
                work composer: 'Adams', title: 'Chamber Symphony', italicized: true
            }
        }

        musicExp {
            institution 'National Youth Symphony'
            role 'Prep conductor for side-by-side performance with Daniel Harding and the Royal Concertgebouw Orchestra'
            date month: 'February', year: 2019

            works {
                work composer: 'Schumann', title: 'Overture to Manfred', italicized: true
            }
        }

        musicExp {
            institution 'The Juilliard Orchestra'
            role 'Prep conductor for Gil Rose.'
            date month: 'January', year: 2019

            works {
                work composer: 'Tippett', title: 'Symphony no. 2'
                work composer: 'Ligeti', title: 'Lontano', italicized: true
                work composer: 'Olivero', title: 'Tenuot', italicized: true
            }
        }

        musicExp {
            institution 'Fordham University Lincoln Center Chamber Orchestra'
            role 'Conductor/professor.'
            date month: 'December', year: 2018

            works {
                work composer: 'Schubert', title: 'Symphony no. 8'
            }
        }

        musicExp {
            institution 'The Juilliard Orchestra'
            role 'Prep conductor for David Robertson'
            date month: 'September', year: 2018

            works {
                work composer: 'Brahms', title: 'Tragic Overture', italicized: true
                work composer: 'Verdi', title: 'Overture to La forza del destino', italicized: true
            }
        }

        musicExp {
            institution 'The Juilliard School'
            role 'Graduation recital.'
            date month: 'May', year: 2018

            works {
                work composer: 'Sibelius', title: 'Valse triste', italicized: true
                work composer: 'Mahler/Stein', title: 'Symphony no. 4'
            }
        }

        musicExp {
            institution 'Mod Brass'
            role 'Guest conductor.'
            date month: 'May', year: 2018

            works {
                work composer: 'Rautavaara', title: 'Playgrounds for Angels', italicized: true
                work composer: 'Theo Chandler', title: 'Ceremonial Music', italicized: true // world premiere
            }
        }

        musicExp {
            institution 'Juilliard Opera-Comp @ National Sawdust'
            role 'Conductor.'
            date month: 'April', year: 2018

            works {
                work composer: 'Josh Getman', title: 'Oedipus in the District', italicized: true // world premiere
                work composer: 'Sam Wu', title: 'The Rat King', italicized: true // world premiere
            }
        }

        musicExp {
            institution 'Juilliard Lab Orchestra'
            date month: 'April', year: 2018

            works {
                work composer: 'Beethoven', title: 'Symphony no. 4: II.'
                work composer: 'Brahms', title: 'Symphony no. 4: IV.'
            }
        }

        musicExp {
            institution 'Charleston Symphony Orchestra'
            role 'Finalist, assistant conductor search.'
            date month: 'April', year: 2018
        }

        musicExp {
            institution 'The Juilliard Orchestra'
            role 'Prep conductor for Alan Gilbert'
            date month: 'March', year: 2018

            works {
                work composer: 'Barber', title: 'First Essay', italicized: true
                work composer: 'Rouse', title: 'Flute Concerto', italicized: true
                work composer: 'Brahms', title: 'Symphony no. 1'
            }

        }

        exp {
            institution 'Indianapolis Symphony Orchestra'
            role 'Finalist, assistant conductor search.'
            date month: 'March', year: 2018
        }

        musicExp {
            institution 'Juilliard Focus! Festival'
            role 'Guest conductor.'
            date month: 'January', year: 2018

            works {
                work composer: 'Yuhui Liu', title: 'Song of the Tie-Dyeing', italicized: true
            }
        }

        musicExp {
            institution 'The Juilliard School'
            role 'Conductor for faculty recital by Frank Morelli.'
            date month: 'January', year: 2018

            works {
                work composer: 'Gubaidulina', title: 'Concerto for Bassoon and Low Strings', italicized: true
            }
        }

        musicExp {
            institution 'Juilliard Lab Orchestra'
            date month: 'December', year: 2017

            works {
                work composer: 'Debussy', title: "Prélude à l'après-midi d'un faune", italicized: true
            }
        }

        musicExp {
            institution 'Orlando Philharmonic'
            role 'Assistant conductor for Eric Jacobsen.'
            date month: 'October', year: 2017

            works {
                work composer: 'Dvořak', title: 'Silent Woods', italicized: true
                work composer: 'Greenstein', title: 'Flute Concerto', italicized: true
                work composer: 'Elgar', title: 'Enigma Variations', italicized: true
            }
        }

        musicExp {
            institution 'Orlando Philharmonic'
            role 'Assistant conductor for Eric Jacobsen.'
            date month: 'October', year: 2017

            works {
                work composer: 'The Beatles', title: 'Sgt. Pepper (arr. for orchestra)', italicized: true
            }

        }

        musicExp {
            institution 'The Juilliard Orchestra'
            role 'Prep conductor for Gerard Schwarz.'
            date month: 'October', year: 2017

            works {
                work composer: 'Schuman', title: 'Symphony no. 6'
                work composer: 'Druckman', title: 'Viola Concerto', italicized: true
                work composer: 'Diamond', title: 'Symphony no. 4'
            }
        }

        musicExp {
            institution 'The Juilliard Orchestra'
            role 'Prep conductor for Alan Gilbert.'
            date month: 'September', year: 2017

            works {
                work composer: 'Tchaikovsky', title: 'Symphony no. 4'
            }
        }

        musicExp {
            institution 'Juilliard Lab Orchestra'
            date month: 'April', year: 2017

            works {
                work composer: 'Britten', title: 'Four Sea Interludes', italicized: true
                work composer: 'Brahms', title: 'Symphony no. 3: II.'
            }
        }

        exp {
            institution 'The Juilliard Orchestra'
            date month: 'March', year: 2017
            role 'Assistant conductor for Jeff Milarsky'
            description 'Four new student works for orchestra.'
        }

        exp {
            institution 'Juilliard Pre-College Symphony'
            date month: 'March', year: 2017
            role 'Guest conductor.'
            description 'Reading of four new student works.'
        }

        musicExp {
            institution 'Juilliard Pre-College Symphony'
            date month: 'January', year: 2017
            role 'Guest conductor for one rehearsal.'

            works {
                work composer: 'Wagner', title: 'Overture to Der fliegende Holländer', italicized: true
                work composer: 'Hindemith', title: 'Symphonic Metamorphosis', italicized: true
                work composer: 'Beethoven', title: 'Piano Concerto no. 1'
            }
        }

        musicExp {
            institution 'The Juilliard Orchestra'
            role 'Prep conductor for Gary Wedow.'
            date month: 'January', year: 2017

            works {
                work composer: 'Mozart/Robert Levin', title: 'Requiem', italicized: true
            }
        }

        musicExp {
            institution 'The Juilliard Orchestra'
            date month: 'January', year: 2017
            role 'Assistant conductor for Alan Gilbert.'

            works {
                work composer: 'Dutilleux', title: 'Tout un monde lointain', italicized: true
                work composer: 'Shostakovich', title: 'Symphony no. 4'
            }
        }

    }

    workshops {

        sectionName 'Conducting Workshops and Festivals'

        workshop {
            workshopName 'String Orchestra of Brooklyn Conducting Workshop'
            date month: 'January', year: 2015
            location 'Brooklyn, New York'
            instructor 'Tito Muñoz'
        }

        workshop {
            workshopName 'Conducting Masterclass and Workshop Series'
            date month: 'December', year: 2014
            location 'Chicago, Illinois'
            instructor 'Donald Schleicher'
        }

    }

}