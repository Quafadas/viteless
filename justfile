setup-ide:
  scala-cli setup-ide .

dev:
  cs launch --contrib sjsls -- --path-to-index-html {{justfile_directory()}}/html