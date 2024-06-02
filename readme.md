An example of using an experimental scala JS live server implementation.

## Prerequisites

It is assumed, that scala-clia, coursier and just are installed, and that

`scala-cli --version` ,  `cs version` prints something reasonable. Use scala-cli 1.3.2+ for the best experience.

## TL;DR

```sh
scala-cli --version && \
cs version && \
git clone https://github.com/Quafadas/viteless.git && \
cd viteless && \
cs launch io.github.quafadas:live-server-scala-cli-js_3:0.0.21
```

## Usage

See the justfile.

## Getting started
The main branch is the "hello world" example. To run it, use `just dev`.

## Extra stuff
The spa_style_deps branch is a more complex example that
- uses waypoint for client side routing
- reloads style changed without page refresh
- uses shoelace

Switch to that branch and run `just dev`.

## External index.html
Usually at some point, you'll want to write your own index.html. You can server that out of the
