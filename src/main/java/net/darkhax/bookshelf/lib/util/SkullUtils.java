package net.darkhax.bookshelf.lib.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

@SuppressWarnings("deprecation")
public class SkullUtils {

    /**
     * Create a skull from the player instance.
     *
     * @param player: The player to use the skin from.
     * @return ItemStack: An itemstack with the skull.
     */
    public static ItemStack createSkull (EntityPlayer player) {
        return createSkull(player.getUniqueID());
    }

    /**
     * Create a skull from the player UUID.
     *
     * @param uuid: The player's UUID.
     * @return ItemStack: An itemstack with the skull.
     */
    public static ItemStack createSkull (UUID uuid) {
        ItemStack stack = new ItemStack(Items.skull, 1, 3);

        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null)
            tagCompound = new NBTTagCompound();

        tagCompound.setString("SkullOwner", uuid.toString());
        stack.setTagCompound(tagCompound);

        return stack;
    }

    /**
     * Deprecated, use UUIDs instead!
     *
     * @param username: The username of the player to use the skin from.
     * @return ItemStack: An itemstack with the skull.
     */
    @Deprecated
    public static ItemStack createSkullFromUsername (String username) {
        ItemStack stack = new ItemStack(Items.skull, 1, 3);

        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null)
            tagCompound = new NBTTagCompound();

        tagCompound.setString("SkullOwner", username);
        stack.setTagCompound(tagCompound);

        return stack;
    }

    public static ItemStack getWitherSkeletonSkull () {
        return new ItemStack(Items.skull, 1, 1);
    }

    public static ItemStack getZombieSkull () {
        return new ItemStack(Items.skull, 1, 2);
    }

    public static ItemStack getCreeperSkull () {
        return new ItemStack(Items.skull, 1, 4);
    }

    public static ItemStack getSteveSkull () {
        return new ItemStack(Items.skull, 1, 3);
    }

    public static ItemStack getSkeletonSkull () {
        return new ItemStack(Items.skull, 1, 0);
    }

    /**
     * Receive all built-in skull textures in a list, except the skulls from the creative menu.
     *
     * @return ItemStack[]: All built-in skull textures.
     */
    public static ItemStack[] getMojangSkulls () {
        return new ItemStack[] {getAlexSkull(), getArrowDownSkull(), getArrowLeftSkull(), getArrowRightSkull(), getArrowUpSkull(), getBlazeSkull(), getCactusSkull(), getCakeSkull(), getCaveSpiderSkull(), getChickenSkull(), getBrownCoconutSkull(), getGreenCoconutSkull(), getCowSkull(), getEndermanSkull(), getExclamationSkull(), getGhastSkull(), getIronGolemSkull(), getHerobrineSkull(), getMagmaCubeSkull(), getMelonSkull(), getMooshroomCowSkull(), getOakLogSkull(), getOcelotSkull(), getPigSkull(), getPigmanSkull(), getGreenPresentSkull(), getRedPresentSkull(), getQuestionSkull(), getSheepSkull(), getSlimeSkull(), getSpiderSkull(), getSquidSkull(), getTNTSkullWithText(), getTNTSkullWithoutText(), getVillagerSkull() };
    }

    /**
     * Deprecated, use one of the getters below.
     */
    @Deprecated
    public static ItemStack createMojangSkull (String mojangSkullType) {
        return createSkullFromUsername("MHF_" + mojangSkullType);
    }

    public static ItemStack getCowSkull () {
        return createMojangSkull("Cow");
    }

    public static ItemStack getSquidSkull () {
        return createMojangSkull("Squid");
    }

    public static ItemStack getSheepSkull () {
        return createMojangSkull("Sheep");
    }

    public static ItemStack getAlexSkull () {
        return createMojangSkull("Alex");
    }

    public static ItemStack getBlazeSkull () {
        return createMojangSkull("Blaze");
    }

    public static ItemStack getCaveSpiderSkull () {
        return createMojangSkull("CaveSpider");
    }

    public static ItemStack getChickenSkull () {
        return createMojangSkull("Chicken");
    }

    public static ItemStack getEndermanSkull () {
        return createMojangSkull("Enderman");
    }

    public static ItemStack getGhastSkull () {
        return createMojangSkull("Ghast");
    }

    public static ItemStack getIronGolemSkull () {
        return createMojangSkull("Golem");
    }

    public static ItemStack getHerobrineSkull () {
        return createMojangSkull("Herobrine");
    }

    public static ItemStack getMagmaCubeSkull () {
        return createMojangSkull("LavaSlime");
    }

    public static ItemStack getMooshroomCowSkull () {
        return createMojangSkull("MushroomCow");
    }

    public static ItemStack getOcelotSkull () {
        return createMojangSkull("Ocelot");
    }

    public static ItemStack getPigSkull () {
        return createMojangSkull("Pig");
    }

    public static ItemStack getPigmanSkull () {
        return createMojangSkull("PigZombie");
    }

    public static ItemStack getSlimeSkull () {
        return createMojangSkull("Slime");
    }

    public static ItemStack getSpiderSkull () {
        return createMojangSkull("Spider");
    }

    public static ItemStack getVillagerSkull () {
        return createMojangSkull("Villager");
    }

    public static ItemStack getCactusSkull () {
        return createMojangSkull("Cactus");
    }

    public static ItemStack getCakeSkull () {
        return createMojangSkull("Cake");
    }

    public static ItemStack getBrownCoconutSkull () {
        return createMojangSkull("CoconutB");
    }

    public static ItemStack getGreenCoconutSkull () {
        return createMojangSkull("CoconutG");
    }

    public static ItemStack getMelonSkull () {
        return createMojangSkull("Melon");
    }

    public static ItemStack getOakLogSkull () {
        return createMojangSkull("OakLog");
    }

    public static ItemStack getGreenPresentSkull () {
        return createMojangSkull("Present1");
    }

    public static ItemStack getRedPresentSkull () {
        return createMojangSkull("Present2");
    }

    public static ItemStack getTNTSkullWithText () {
        return createMojangSkull("TNT");
    }

    public static ItemStack getTNTSkullWithoutText () {
        return createMojangSkull("TNT2");
    }

    public static ItemStack getArrowUpSkull () {
        return createMojangSkull("ArrowUp");
    }

    public static ItemStack getArrowDownSkull () {
        return createMojangSkull("ArrowDown");
    }

    public static ItemStack getArrowLeftSkull () {
        return createMojangSkull("ArrowLeft");
    }

    public static ItemStack getArrowRightSkull () {
        return createMojangSkull("ArrowRight");
    }

    public static ItemStack getExclamationSkull () {
        return createMojangSkull("Exclamation");
    }

    public static ItemStack getQuestionSkull () {
        return createMojangSkull("Question");
    }
}
