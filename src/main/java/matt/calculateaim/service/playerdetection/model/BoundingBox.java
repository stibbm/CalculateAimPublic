package matt.calculateaim.service.playerdetection.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundingBox implements Serializable {
	private Integer x1;
	private Integer x2;
	private Integer y1;
	private Integer y2;

	public Integer getCenterX() {
		Double xCenter = (x1.doubleValue() + x2.doubleValue()) / 2.0;
		return xCenter.intValue();
	}

	public Integer getCenterY() {
		Double yCenter = (y1.doubleValue() + y2.doubleValue()) / 2.0;
		return yCenter.intValue();
	}
}
