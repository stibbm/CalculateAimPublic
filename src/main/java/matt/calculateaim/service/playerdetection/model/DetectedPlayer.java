package matt.calculateaim.service.playerdetection.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetectedPlayer implements Serializable {
	@SerializedName("video_file_path_string")
	private String videoFilePathString;

	@SerializedName("detected_player_index")
	private String detectedPlayerIndex;

	@SerializedName("image_index")
	private Integer imageIndex;

	@SerializedName("timestamp")
	private Double timestamp;

	@SerializedName("image_file_path_string")
	private String imageFilePathString;

	private Double x1;
	private Double x2;
	private Double y1;
	private Double y2;

	@SerializedName("image_width")
	private Integer imageWidth;

	@SerializedName("image_height")
	private Integer imageHeight;

	@SerializedName("confidence")
	private Double confidence;

	@SerializedName("class_id")
	private Integer classId;

	public BoundingBox getBoundingBox() {
		
	}
}
