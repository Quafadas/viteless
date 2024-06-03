setup-ide:
  scala-cli setup-ide .

dev:
  cs launch io.github.quafadas:live-server-scala-cli-js_3:0.1.1 -- --port 3001 --client-routes-prefix app --styles-dir {{invocation_directory()}}/styles