setup-ide:
  scala-cli setup-ide .

dev:
  cs launch --contrib sjsls -- --port 3010 --path-to-index-html {{justfile_directory()}}/assets