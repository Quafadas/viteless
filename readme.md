An example of using an experimental scala JS live server implementation.

## Prerequisites

It is assumed, that scala-clia and coursier are installed, and that

`scala-cli --version` , and `cs version` prints something reasonable. Use scala-cli 1.3.2+ for the best experience.


## Usage

See the justfile.

The main branch is the "hello world" example. To run it, use `just dev`.

The spa_style_deps branch is a more complex example that
- uses waypoint for client side routing
- reloads style changed without page refresh
- uses shoelace

Switch to that branch and run `just dev`.

