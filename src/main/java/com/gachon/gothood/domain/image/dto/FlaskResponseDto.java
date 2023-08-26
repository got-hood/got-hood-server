package com.gachon.gothood.domain.image.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter @Setter
@Builder
public class FlaskResponseDto {

    @JsonProperty("AgeRange")
    private AgeRange ageRange;
    @JsonProperty("Beard")
    private Beard beard;
    @JsonProperty("BoundingBox")
    private BoundingBox boundingBox;
    @JsonProperty("Confidence")
    private double confidence;
    @JsonProperty("Emotions")
    private List<Emotion> emotions;
    @JsonProperty("EyeDirection")
    private EyeDirection eyeDirection;
    @JsonProperty("Eyeglasses")
    private Eyeglasses eyeglasses;
    @JsonProperty("EyesOpen")
    private EyesOpen eyesOpen;
    @JsonProperty("FaceOccluded")
    private FaceOccluded faceOccluded;
    @JsonProperty("Gender")
    private Gender gender;
    @JsonProperty("Landmarks")
    private List<Landmark> landmarks;
    @JsonProperty("MouthOpen")
    private MouthOpen mouthOpen;
    @JsonProperty("Mustache")
    private Mustache mustache;
    @JsonProperty("Pose")
    private Pose pose;
    @JsonProperty("Quality")
    private Quality quality;
    @JsonProperty("Smile")
    private Smile smile;
    @JsonProperty("Sunglasses")
    private Sunglasses sunglasses;

    public static class AgeRange {
        @JsonProperty("High")
        private int high;
        @JsonProperty("Low")
        private int low;
    }

    public static class Beard {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class BoundingBox {
        @JsonProperty("Height")
        private double height;
        @JsonProperty("Left")
        private double left;
        @JsonProperty("Top")
        private double top;
        @JsonProperty("Width")
        private double width;
        // Getter and Setter methods
    }

    public static class Emotion {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Type")
        private String type;
        // Getter and Setter methods
    }

    public static class EyeDirection {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Pitch")
        private double pitch;
        @JsonProperty("Yaw")
        private double yaw;
        // Getter and Setter methods
    }

    public static class Eyeglasses {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class EyesOpen {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class FaceOccluded {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class Gender {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private String value;
        // Getter and Setter methods
    }

    public static class Landmark {
        @JsonProperty("Type")
        private String type;
        @JsonProperty("X")
        private double x;
        @JsonProperty("Y")
        private double y;
        // Getter and Setter methods
    }

    public static class MouthOpen {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class Mustache {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class Pose {
        @JsonProperty("Pitch")
        private double pitch;
        @JsonProperty("Roll")
        private double roll;
        @JsonProperty("Yaw")
        private double yaw;
        // Getter and Setter methods
    }

    public static class Quality {
        @JsonProperty("Brightness")
        private double brightness;
        @JsonProperty("Sharpness")
        private double sharpness;
        // Getter and Setter methods
    }

    public static class Smile {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    public static class Sunglasses {
        @JsonProperty("Confidence")
        private double confidence;
        @JsonProperty("Value")
        private boolean value;
        // Getter and Setter methods
    }

    // Getter and Setter methods for the main DTO class
}