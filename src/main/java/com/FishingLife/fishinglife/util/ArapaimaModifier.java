/*package com.fisherman_alike.util;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ArapaimaModifier extends LootModifier {
    public static final Supplier<Codec<ArapaimaModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            .fieldOf("item").forGetter(m -> m.item)).apply(inst, ArapaimaModifier::new)));

    private final Item item;

    protected ArapaimaModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if ( generatedLoot.get(0).is(ItemTags.FISHES) ) {
            if ( context.getRandom().nextDouble() <= 0.9 ) {
                generatedLoot.clear();
                generatedLoot.add(new ItemStack(item, 1));
            }
        }
        return generatedLoot;
    }
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

}


 */

