# Dumb Groovy CLI thing

How one could use Groovy to encode passwords on the command-line.

* However, you should *never* pass passwords around on the command-line.
* Perhaps this should just have been a gist, but shows the AWESOME power of [(Apache) Groovy](http://groovy-lang.org/).

## Usage

```bash
❯ groovy Encoder 'my-awesome-new-password-is-not-abc123'
c183b67c7d88e90d20c71a8b6dc795c74f71efbb6fd34aa52eee138583648c900bcd17e6866e3d95
```

Or with a salt:

```bash
❯ groovy Encoder  'my-awesome-new-password-is-not-abc123' 'secret-salt'
c183b67c7d88e90d20c71a8b6dc795c74f71efbb6fd34aa52eee138583648c900bcd17e6866e3d95
```

## Test

A dumb test:

```bash
groovy Encoder  'my-awesome-new-password-is-not-abc123' | \
  groovy TestEncoder  'my-awesome-new-password-is-not-abc123' | \

groovy Encoder  'my-awesome-new-password-is-not-abc123' 'secret-salt' | \
  groovy TestEncoder  'my-awesome-new-password-is-not-abc123' 'secret-salt' | \
```

### Author, Copyright

Copyright &#x24B8; 2017 [Nicolas Doye](https://worldofnic.org)

### License

[Apache License, Version 2.0](https://opensource.org/licenses/Apache-2.0)