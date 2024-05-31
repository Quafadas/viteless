setup-ide:
  scala-cli setup-ide .

dev:
  cs launch io.github.quafadas:live-server-scala-cli-js_3:0.0.19-3-b0f9ef -- --port 3001 --client-routes-prefix app --styles-dir {{invocation_directory()}}/styles