package nl.jellejurre.seedchecker.serverMocks;

import com.mojang.serialization.Lifecycle;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.resource.DataPackSettings;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameMode;
import net.minecraft.world.GameRules;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.level.LevelInfo;
import net.minecraft.world.level.ServerWorldProperties;
import org.jetbrains.annotations.Nullable;
import project.WorldPresetMode;

import java.util.Set;

public class FakeSaveProperties implements SaveProperties {
    private static final ThreadLocal<WorldPresetMode> WORLD_PRESET_MODE =
            ThreadLocal.withInitial(() -> WorldPresetMode.NORMAL);

    private final FakeServerWorldProperties fakeServerWorldProperties = new FakeServerWorldProperties();
    private final GeneratorOptions generatorOptions;

    public FakeSaveProperties(DynamicRegistryManager.Impl registryManager, long seed) {
        GeneratorType generatorType = WORLD_PRESET_MODE.get() == WorldPresetMode.LARGE_BIOMES
                ? GeneratorType.LARGE_BIOMES
                : GeneratorType.DEFAULT;
        generatorOptions = generatorType.createDefaultOptions(registryManager, seed, true, false);
    }

    public static void setWorldPresetMode(WorldPresetMode worldPresetMode) {
        WORLD_PRESET_MODE.set(worldPresetMode == null ? WorldPresetMode.NORMAL : worldPresetMode);
    }

    public static void clearWorldPresetMode() {
        WORLD_PRESET_MODE.remove();
    }

    @Override
    public DataPackSettings getDataPackSettings() {
        return null;
    }

    @Override
    public void updateLevelInfo(DataPackSettings dataPackSettings) {
    }

    @Override
    public boolean isModded() {
        return false;
    }

    @Override
    public Set<String> getServerBrands() {
        return null;
    }

    @Override
    public void addServerBrand(String brand, boolean modded) {
    }

    @Nullable
    @Override
    public NbtCompound getCustomBossEvents() {
        return null;
    }

    @Override
    public void setCustomBossEvents(@Nullable NbtCompound nbt) {
    }

    @Override
    public ServerWorldProperties getMainWorldProperties() {
        return this.fakeServerWorldProperties;
    }

    @Override
    public LevelInfo getLevelInfo() {
        return null;
    }

    @Override
    public NbtCompound cloneWorldNbt(DynamicRegistryManager registryManager,
                                     @Nullable NbtCompound playerNbt) {
        return null;
    }

    @Override
    public boolean isHardcore() {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public String getLevelName() {
        return null;
    }

    @Override
    public GameMode getGameMode() {
        return null;
    }

    @Override
    public void setGameMode(GameMode gameMode) {
    }

    @Override
    public boolean areCommandsAllowed() {
        return false;
    }

    @Override
    public Difficulty getDifficulty() {
        return null;
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
    }

    @Override
    public boolean isDifficultyLocked() {
        return false;
    }

    @Override
    public void setDifficultyLocked(boolean locked) {
    }

    @Override
    public GameRules getGameRules() {
        return null;
    }

    @Override
    public NbtCompound getPlayerData() {
        return null;
    }

    @Override
    public NbtCompound getDragonFight() {
        return null;
    }

    @Override
    public void setDragonFight(NbtCompound nbt) {
    }

    @Override
    public GeneratorOptions getGeneratorOptions() {
        return this.generatorOptions;
    }

    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
