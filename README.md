# hit-hobbits

Hit a hobbit once or a specified number of times

## Run

    $ lein run
    Hit you in the chest!

    $ lein run 2
    Hit you in the back!
    Hit you in the right hand!
    I think you've had enough.

    $ lein run 1
    Hit you in the left lower leg!
    I think you've had enough.

    $ lein run 0
    I think you've had enough.

## Compile and Run

    $ lein uberjar
    Compiling hit-hobbits.core
    Created /Users/amar/Code/hit-hobbits/target/uberjar/hit-hobbits-0.1.0-SNAPSHOT.jar
    Created /Users/amar/Code/hit-hobbits/target/uberjar/hit-hobbits-0.1.0-SNAPSHOT-standalone.jar

    $ java -jar ./target/uberjar/hit-hobbits-0.1.0-SNAPSHOT-standalone.jar
    Hit you in the back!

    $ java -jar ./target/uberjar/hit-hobbits-0.1.0-SNAPSHOT-standalone.jar 2
    Hit you in the left kidney!
    Hit you in the right shoulder!
    I think you've had enough.

    $ java -jar ./target/uberjar/hit-hobbits-0.1.0-SNAPSHOT-standalone.jar 1
    Hit you in the right knee!
    I think you've had enough.

    $ java -jar ./target/uberjar/hit-hobbits-0.1.0-SNAPSHOT-standalone.jar 0
    I think you've had enough.
