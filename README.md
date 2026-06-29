# Boat Ruins Mod 🚢

A Fabric mod that adds procedurally generated **abandoned shipwreck ruins** to your ocean biomes — each with unique loot and structure variants.

---

## Features

- **3 Structure Variants** — Intact, decayed, and looted shipwrecks randomly selected during world generation
- **5 Custom Loot Tables** — Junk, food, minerals, gear, and rare treasure chests
- **Cartographer Explorer Map** — Cartographer villagers (Level 3) sell a map leading directly to the nearest boat ruins
- **Vanilla-Friendly** — Structures spawn naturally in all `#minecraft:is_ocean` biomes using standard worldgen systems
- **Data-Driven** — Fully data-pack compatible JSON configuration for easy tweaking

---

## Supported Versions

| Component | Version |
|-----------|---------|
| Minecraft | **26.2** |
| Fabric Loader | **0.19.3+** |
| Fabric API | **0.152.1+26.2** |
| Java | **25** |

---

## In-Game Commands

### Locate Boat Ruins
```
/locate structure boat_ruins_mod:legacy_boat_ruins
```

### Get Loot Chests (5 variants)
```
/give @s chest[container_loot={loot_table:"boat_ruins_mod:chests/junk"}]
/give @s chest[container_loot={loot_table:"boat_ruins_mod:chests/food"}]
/give @s chest[container_loot={loot_table:"boat_ruins_mod:chests/mineral"}]
/give @s chest[container_loot={loot_table:"boat_ruins_mod:chests/gear"}]
/give @s chest[container_loot={loot_table:"boat_ruins_mod:chests/treasure"}]
```

---

## Structure Variants

| Variant | Weight | Probability |
|---------|--------|-------------|
| Decayed Shipwreck | 8 | 53.3% |
| Looted Shipwreck | 5 | 33.3% |
| Intact Shipwreck | 2 | 13.3% |

---

## Loot Tables

| Table | Contents |
|-------|----------|
| `junk` | Oak planks, string, coal, iron nuggets, wooden tools |
| `food` | Bread, cooked fish, apples, dried kelp, cookies |
| `mineral` | Iron, gold, copper ingots; lapis, redstone; rare diamond |
| `gear` | Iron armor, shield, iron sword, arrows, enchanted bow |
| `treasure` | Diamonds, emeralds, enchanted golden apple, heart of the sea, high-level enchanted book |

---

## Installation

1. Install **Fabric Loader 0.19.3+** for Minecraft 26.2
2. Install **Fabric API** (0.152.1+26.2)
3. Drop `boat_ruins_mod-1.0.0.jar` into your `mods/` folder
4. Launch the game

---

## Build from Source

```bash
git clone <repo-url>
cd fabric-example-mod-26.1.2
./gradlew genSources
./gradlew build
# Output: build/libs/boat_ruins_mod-1.0.0.jar
```

---

## Project Structure

```
src/main/resources/data/boat_ruins_mod/
├── loot_tables/chests/         # 5 custom loot tables
├── structure/                   # 3 NBT shipwreck templates
├── villager_trade/              # Cartographer trade definition
├── tags/worldgen/structure/     # Explorer map structure tag
└── worldgen/
    ├── structure/               # Main structure config
    ├── template_pool/           # Variant random pool
    └── structure_set/           # Worldgen rarity settings
```

---

## License

This project is available under the CC0 license. Feel free to use it in your own modpacks or projects.
