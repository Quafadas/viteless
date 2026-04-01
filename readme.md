# Develop

`mill -w app.serve`

I haven't yet found a way to correctly clean up the server when it's interrupted with ctrl-c, so you may have to kill the process manually. The server will automatically restart when you change any source file, and it will also trigger a reload in the browser.

# Publish

`mill show app.publish`