package com.techconative.library.config.util;

import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class CommonUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <S, D> void mapNonNullProperties(S source, D destination) {
        Condition<?, ?> notNull = ctx -> ctx.getSource() != null;
        modelMapper.getConfiguration().setPropertyCondition(notNull);

        modelMapper.map(source, destination);
    }
    
    
    public static <S, D> D mapNonNullProperties(S source, Class<D> destinationType) {
        Condition<?, ?> notNull = ctx -> ctx.getSource() != null;
        modelMapper.getConfiguration().setPropertyCondition(notNull);

        return modelMapper.map(source, destinationType);
    }
}

