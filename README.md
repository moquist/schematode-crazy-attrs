# schematode-crazy-attrs

This is a quick demo showing how to make sure your [Datomic
Schematode](https://github.com/moquist/datomic-schematode) schema
loads properly -- or, more precisely, this shows what happens when you
put crazy attribute types in your schema. This is relevant, because
it's really easy to type :int when you meant to say :long.

## Usage

1. Load up your REPL.
1. ```(require 'schematode-crazy-attrs.core)```
1. ```(schematode-crazy-attrs.core/demo)```

## License

Copyright © 2015 Matt Oquist <moquist@majen.net>

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
