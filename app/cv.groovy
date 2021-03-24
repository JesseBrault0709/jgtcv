import com.brault.jgtcv.simplecv.script.SimpleCVScript
import groovy.transform.BaseScript

@BaseScript
SimpleCVScript base

cv {
    heading {
        name 'Jesse Brault'
        professionalTitle 'Conductor and Composer'
        documentTitle 'Curriculum Vitae'
    }

    education {

        degree {
            institution 'St. Olaf College'
            degreeName 'Bachelor of Music'
            major 'Theory and Composition'
            gpa '3.91'

            dates {
                start year: 2009
                end year: 2013
            }

            privateTeachers {
                name 'Steven Amundson'
                name 'Timothy Mahr'
                name 'Justin Merritt'
            }

            relevantCoursework {
                course 'composition'
                course 'theory'
                course 'conducting'
                course 'music history'
                course 'counterpoint'
            }
        }

        degree {
            institution 'The Juilliard School'
            degreeName 'Master of Music'
            major 'Orchestral Conducting'

            dates {
                start year: 2015
                end year: 2018
            }

            privateTeachers {
                name 'Alan Gilbert'
                name 'James Ross'
            }

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
                toPresent true
            }

            duties {
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

        exp {
            institution 'Boston Symphony Orchestra'
            role 'Cover conductor for Yuan Chang.'

            date month: 'January', year: 2020

            works {
                work composer: 'Chihchun Chi-sun Lee', title: 'Formosan Triptych', italicized: true
                work composer: 'Mozart', title: 'Piano concerto no. 25'
                work composer: 'Tchaikovsky', title: 'Symphony no. 3'
            }

        }

        exp {
            institution 'New Jersey Symphony Orchestra'
            role 'Cover conductor for Xian Zhang.'
            date month: 'December', year: 2019

            works {
                work composer: 'Anna Clyne', title: 'Within Her Arms', italicized: true
                work composer: 'Rachmaninov', title: 'Piano concerto no. 3'
                work composer: 'Dvořák', title: 'Symphony no. 8'
            }
        }

        exp {
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

        exp {
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

        exp {
            institution 'Juilliard Pre-College Symphony'
            role 'Assistant conductor for James Ross.'
            date month: 'September', year: 2019

            works {
                work composer: 'Boulanger', title: "D'un soir triste", italicized: true
                work composer: 'Bruch', title: 'Violin Concerto', italicized: true
                work composer: 'Thompson', title: 'Symphony no. 2'
            }
        }

        exp {
            institution 'Fordham University Lincoln Center Chamber Orchestra'
            role 'Professor and conductor.'
            description 'Spring semester culminating performance.'
            date month: 'April', year: 2019

            works {
                work composer: 'Beethoven', title: 'Symphony no. 6'
                work composer: 'Bartók', title: 'Romanian Folk Dances', italicized: true
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