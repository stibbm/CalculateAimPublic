package matt.calculateaim.service.playerdetection.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetectedPlayerData implements Serializable {
	private List<DetectedPlayer> data;
}
