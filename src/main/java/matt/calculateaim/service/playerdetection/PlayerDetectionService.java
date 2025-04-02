package matt.calculateaim.service.playerdetection;

import java.io.IOException;

public interface PlayerDetectionService {
	DetectedPlayerData detectPlayersInVideo(
		String inputImageFilePathString,
		String modelFilePathString,
		Integer modelResolution
	) throws IOException;
}