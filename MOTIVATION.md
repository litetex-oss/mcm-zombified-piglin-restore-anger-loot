

## Efficiency of combined Gold/XP farms

Expected impact for [Ilmango's Gold/XP farm 1.21](https://www.youtube.com/watch?v=P6TanacO3cA).

| Version | Cumulated gold blocks/h | XP/h | Notes |
| --- | --- | --- | --- |
| 1.21.4 | ~130 | ~115k |  |
| 25w02a | ~87 (-33%) | 0 | <ul><li>XP is no longer dropped</li><li>Gold ingots are no longer dropped</li></ul> |

Most overworld portal farms are likely also affected by this change.

This impact is huge considering building the farm already requires substantial amounts of time, resources and knowledge.

### Possible alternatives

that meet the requirements of the original:

| Method (Example linked) | Requires auto clicker? | Gold | XP | Notes |
| --- | --- | --- | --- | --- |
| [Gold only farm](https://www.youtube.com/watch?v=DLe5-THpQ6I) | <span style="color:green">No</span> | <span style="color:green">Yes</span> <sup>Lower drop rates - no ingots dropped</sup> | <span style="color:red">No</span> | |
| [Looting gold farm](https://www.youtube.com/watch?v=-tWH2dUWc_Y) | <span style="color:red">Yes</span> | <span style="color:green">Yes</span> | <span style="color:green">Yes</span> |  |
| Various XP farms | <span style="color:red">Yes</span> | <span style="color:red">No</span> | <span style="color:green">Yes</span> | Examples: <ul><li><a href="https://www.youtube.com/watch?v=nh8voJScSbw">Enderman farm</a></li><li><a href="https://www.youtube.com/watch?v=dfwsIpmOwd4">Guardian XP farm (Nether based)</a><br/> NOTE: might be problematic on multiplayer servers</li><li><a href="https://www.youtube.com/watch?v=i6yG44CCSm4">Pillager XP farm (Raid based)</a><br/> NOTE: Raid system was changed in 1.21, might need some rework or <a href="https://github.com/litetex-oss/mcm-raid-restore">compatibility mod</a></li></ul> | 

**Conclusion**:<br/>There is no drop-in replacement, one has to build 2 new farms.

## The nerf itself
[Once again](https://github.com/litetex-oss/mcm-raid-restore/blob/dev/MOTIVATION.md) an interesting technical mechanic - that has been in the game for a long time (over 10 years!) - gets nerfed/removed.

There are some problems with that:
* The mechanic was classified as a bug because it [was "inconsistent" and "makes no sense"](https://www.reddit.com/user/sliced_lime/comments/gzpo5p/some_words_on_things_in_116/) and should therefore not be in the game.
    * If one starts arguing like this we can likely throw most game mechanics out of the window since they "make no sense", for example:
        * Phantom spawning - in particular on multi-player server (did you ever try to sleep on a server with 50+ active players?)
        * the [Villager trade rebalance experiment](https://minecraft.wiki/w/Villager_Trade_Rebalance) ("Librarians only sell certain books in certain biomes")
        * the 1.21 raid/bad omen system ("drink bottle of evil")
        * Cactus destroying all items
        * Water bucket MLGs
        * hundreds of other things
* The mechanic was [known to be a unintended since 2014](https://bugs.mojang.com/browse/MC-56653?focusedId=207675#comment-207675), however NOTHING was done to fix it until ~6 years later (1.16).<br/>You can't just expect people to not use it, if it's been there for years.<br/>_Either implement it as it should work from the start, do alternatives or not implement it at all in the first place!_
    * The same reasoning also caused controversy in the past:
        * [Iron farms (1.14)](https://www.youtube.com/watch?v=R6Q7gPbMyr8)
        * [Raids (1.14)](https://www.youtube.com/watch?v=kVlDtWRoWuA)
        * [Various mechanics (1.14)](https://www.youtube.com/watch?v=ZL9aBeD5iBQ)
        * Fishing loot nerf (1.16)
        * Villager trade rebalance experiment (pending)
        * Redstone experiment (pending)
        * [Raid farm changes in 1.21](https://github.com/litetex-oss/mcm-raid-restore)
* There was ZERO problem with this behavior despite some "crying" players complaining.<br/>Don't like the mechanic? Well just don't build a XP gold farm. What's the problem?
    * The change was reverted in 1.16 because other players complained, so why was it re-introduced now?
    * The above linked video is ~1 year old and has ~330k views, the original farm video around 3 Mio. It looks like a lot of player like the design and are not complaining about it...
    * Can I just play the game the way I want and not constantly re-build my farms or write mods that restore the original behavior?
* Nowadays there is for nearly everything a gamerule that can be toggled. Yeah but not for this...
