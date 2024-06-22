package owmii.powah.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record EnergyBuffer(long stored, long capacity) {
    public static Codec<EnergyBuffer> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.LONG.fieldOf("stored").forGetter(EnergyBuffer::stored),
            Codec.LONG.fieldOf("capacity").forGetter(EnergyBuffer::capacity)).apply(builder, EnergyBuffer::new));

    public static StreamCodec<ByteBuf, EnergyBuffer> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_LONG, EnergyBuffer::stored,
            ByteBufCodecs.VAR_LONG, EnergyBuffer::capacity,
            EnergyBuffer::new);
}
