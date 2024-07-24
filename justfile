setup-ide:
  scala-cli setup-ide .

dev:
  cs launch --contrib sjsls -- --port 3001 --client-routes-prefix app --styles-dir {{invocation_directory()}}/styles