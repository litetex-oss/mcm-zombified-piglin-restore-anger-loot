# 1.3.1
* Fixed a deadlock upon world generation that occurs when `spawn_zombified_piglin_always_with_sword_on_magma_block` is enabled #170
  * <details><summary>Technical explanation:</summary>

    * World generation is done by the game on dedicated world generation threads and not on the main/server thread
    * During world generation the game tries to populate the newly created chunks with neutral creatures
    * In the nether the neutral creatures populating chunks are striders
    * A zombified piglin can ride a strider (Jockey) and is therefore spawned
    * If the gamerule is enabled the piglin checks for the magma block
    * This check was executed on the wrong World object (because the correct World object is not available out of the box to the method requiring it)
    * The World object detects that it's not running on the main thread and schedules an access call to it (from the world generation thread)
    * The main thread is however currently waiting for the scheduling world generation thread to finish
    * and this causes the deadlock
   </details>

# 1.3.0
* Updated to 26.1

# 1.2.0
* Added Gamerule `spawn_zombified_piglin_always_with_sword_on_magma_block`
   * Defaults to `false`
* Requires fabric-api

# 1.1.0
* Updated to 1.21.11

# 1.0.1
* Migrated to "official" mappings in preparation for the removal of obfuscation
* Now targeting 1.21.10

# 1.0.0
Release for 1.21.5+

# 0.0.X
_Experimental initial release_
