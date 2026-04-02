# Concept

An entirely declarative ScalaJS build.

## Develop

`mill -w app.serve`

TThe server will pulse a refresh event to the (browser) client on code change.

## Publish

`mill show app.assembleSite`

Will place a ready-to-serve site in the out directory
