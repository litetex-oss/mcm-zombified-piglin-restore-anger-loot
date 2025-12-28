<!-- modrinth_exclude.start -->

[![Version](https://img.shields.io/modrinth/v/gMmsTToZ)](https://modrinth.com/mod/zombified-piglin-restore-anger-loot)
[![Build](https://img.shields.io/github/actions/workflow/status/litetex-oss/mcm-zombified-piglin-restore-anger-loot/check-build.yml?branch=dev)](https://github.com/litetex-oss/mcm-zombified-piglin-restore-anger-loot/actions/workflows/check-build.yml?query=branch%3Adev)

# Zombified Piglin restore anger loot

<!-- modrinth_exclude.end -->

Restores the original Zombified Piglin loot mechanic like it was in 1.21

## Configuration

### Gamerule ``spawn_zombified_piglin_always_with_sword_on_magma_block``

Forces Zombified Piglins to **always** spawn with a sword on magma blocks.<br/>
The default is ``false``.

_This gamerule exists because_
* _starting with 1.21.11 Zombified Piglins can spawn with a spear:_
  * _Piglins with spears can hit each other while attacking, which in turn causes retaliation/infighting and therefore lowering the overall effectiveness of farms_
  * _The performed charge attack requires a lot more calculations when compared to a "normal" sword attack_
* _mpost gold farms use magma blocks anyway_
* _all other gameplay aspects are unaffected_

## Motivation/Why does this mod exist?

Gold farms got [significantly nerfed](https://bugs.mojang.com/browse/MC-56653) in [25w02a](https://minecraft.wiki/w/Java_Edition_25w02a).

See also: [More details, comparisons and arguments](https://github.com/litetex-oss/mcm-zombified-piglin-restore-anger-loot/blob/dev/MOTIVATION.md)

<!-- modrinth_exclude.start -->

## Installation
[Installation guide for the latest release](https://github.com/litetex-oss/mcm-zombified-piglin-restore-anger-loot/releases/latest#Installation)

### Usage in other mods

Add the following to ``build.gradle``:
```groovy
dependencies {
    modImplementation 'net.litetex.mcm:zombified-piglin-restore-anger-loot:<version>'
    // Further documentation: https://wiki.fabricmc.net/documentation:fabric_loom
}
```

> [!NOTE]
> The contents are hosted on [Maven Central](https://repo.maven.apache.org/maven2/net/litetex/mcm/). You shouldn't have to change anything as this is the default maven repo.<br/>
> If this somehow shouldn't work you can also try [Modrinth Maven](https://support.modrinth.com/en/articles/8801191-modrinth-maven).

## Contributing
See the [contributing guide](./CONTRIBUTING.md) for detailed instructions on how to get started with our project.

<!-- modrinth_exclude.end -->
