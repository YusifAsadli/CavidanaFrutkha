package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.slider.SliderHomeDto;
import edu.az.itbrains123.ecommerse.models.Slider;
import edu.az.itbrains123.ecommerse.repositories.SliderRepository;
import edu.az.itbrains123.ecommerse.sevices.SliderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SliderServiceImpl implements SliderService {
    private final SliderRepository sliderRepository;
    private final ModelMapper modelMapper;

    public SliderServiceImpl(SliderRepository sliderRepository, ModelMapper modelMapper) {
        this.sliderRepository = sliderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SliderHomeDto> getSliders() {
        List<Slider> sliders = sliderRepository.findAll();
        List<SliderHomeDto> result= sliders.stream().map(slider->modelMapper.map(slider,SliderHomeDto.class)).collect(Collectors.toList());
        return result;
    }
}
