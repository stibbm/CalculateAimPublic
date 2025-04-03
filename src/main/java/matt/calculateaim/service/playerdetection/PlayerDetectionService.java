package matt.calculateaim.service.playerdetection;

import java.io.IOException;

import matt.calculateaim.service.playerdetection.model.DetectedPlayerData;

public interface PlayerDetectionService {
	DetectedPlayerData detectPlayersInVideo(
		String inputVideoFilePathString,
		String modelFilePathString,
		Integer modelResolution
	) throws IOException;

	DetectedPlayerData detectPlayersInVideo(
		String inputVideoFilePathString,
		String modelFilePathString
	) throws IOException;

	DetectedPlayerData detectPlayersInVideo(
		String inputVideoFilePathString,
		Integer modelResolution
	) throws IOException;

	DetectedPlayerData detectPlayersInVideo(
		String inputVideoFilePathString
	) throws IOException;
}