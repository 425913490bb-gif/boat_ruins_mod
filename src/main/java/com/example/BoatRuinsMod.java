package com.example;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoatRuinsMod implements ModInitializer {
	public static final String MOD_ID = "boat_ruins_mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/**
	 * 自定义 StructureType — legacy_boat_ruins。
	 * 使用 JigsawStructure 的 Codec，通过简单的 Template Pool（不展开拼图分支）
	 * 从三个沉船 NBT 中随机抽取一个完整结构直接生成。
	 */
	public static final StructureType<JigsawStructure> LEGACY_BOAT_RUINS_TYPE =
		Registry.register(
			BuiltInRegistries.STRUCTURE_TYPE,
			id("legacy_boat_ruins"),
			(StructureType<JigsawStructure>) () -> JigsawStructure.CODEC
		);

	/**
	 * 26.2 制图师村民交易说明：
	 * =========================================================================
	 * 在 26.2 中，村民交易系统已完全迁移为数据驱动（data-driven）。
	 * 不再使用 TradeOfferHelper 等编程式 API，而是通过 JSON 文件 + Tag 标签定义。
	 *
	 * 本模组为制图师（Cartographer）在「学徒-专家」等级（level 3）添加了沉船遗迹
	 * 探险家地图交易，具体数据文件如下：
	 *
	 * 1. 交易定义 JSON：
	 *    data/boat_ruins_mod/villager_trade/cartographer/3/
	 *      emerald_and_compass_boat_ruins_map.json
	 *    → 消耗 14 绿宝石 + 1 指南针，获得指向 legacy_boat_ruins 的探险家地图
	 *    → 使用 exploration_map 物品修饰器，search_radius=100
	 *
	 * 2. 结构目标 Tag：
	 *    data/boat_ruins_mod/tags/worldgen/structure/
	 *      on_boat_ruins_explorer_maps.json
	 *    → 包含 boat_ruins_mod:legacy_boat_ruins，供地图定位系统检索
	 *
	 * 3. Level 3 交易池 Tag 注入（关键步骤）：
	 *    data/minecraft/tags/villager_trade/cartographer/level_3.json
	 *    → 在保留原版 3 条交易的基础上，追加本模组的沉船地图交易
	 *    → 使用 "replace": false 进行追加式合并
	 *
	 * 4. 本地化翻译：
	 *    assets/boat_ruins_mod/lang/en_us.json → "filled_map.boat_ruins"
	 *    → 探险家地图的物品名称
	 *
	 * 交易出现的制图师亚种：全部（无 merchant_predicate 过滤）
	 * 交易等级：3（对应原版海洋神殿/试炼密室地图同级）
	 * =========================================================================
	 */

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world from Boat Ruins Mod!");
		LOGGER.info("Registered structure type: boat_ruins_mod:legacy_boat_ruins");
		LOGGER.info("Cartographer trade: sells legacy_boat_ruins explorer map at level 3");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
