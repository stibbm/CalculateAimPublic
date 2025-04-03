package matt.calculateaim.service.playerdetection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import matt.calculateaim.python.PythonConstants;
import matt.calculateaim.python.PythonInvoker;
import matt.calculateaim.service.playerdetection.model.DetectedPlayerData;

import static matt.calculateaim.python.PythonConstants.PYTHON_INTERPRETER;
import static matt.calculateaim.constants.Constants.GSON;

@Slf4j
public class PlayerDetectionServiceImpl implements PlayerDetectionService {

	public static final String PLAYER_DETECTION_PYTHON_SCRIPT_PATH = "pythonfiles/player_detection/playerdetection.py";
	public static final String DEFAULT_MODEL_FILE_PATH_STRING = "best.pt";
	public static final Integer DEFAULT_MODEL_RESOLUTION = 720;

	private PythonInvoker pythonInvoker;
	private FileUtil fileUtil;

	public PlayerDetectionServiceImpl(
		PythonInvoker pythonInvoker,
		FileUtil fileUtil
	) {
		this.pythonInvoker = pythonInvoker;
		this.fileUtil = fileUtil;
	}

	@Override
	public DetectedPlayerData detectPlayersInVideo(String inputVideoFilePathString, String modelFilePathString,
			Integer modelResolution) throws IOException {
		log.info("detect players in video");
		log.info("inputVideoFilePathString: " + inputVideoFilePathString);
		log.info("modelFilePathString: " + modelFilePathString);
		String resultFilePathString = fileUtil.generateRandomFileName("json", true);
		List<String> argList = new ArrayList<>();
		argList.add(new File(inputVideoFilePathString).getAbsolutePath());
		argList.add(new File(modelFilePathString).getAbsolutePath());
		argList.add(modelResolution.toString());
		argList.add(new File(resultFilePathString).getAbsolutePath());
		this.pythonInvoker.runPython(
			PYTHON_INTERPRETER,
			PLAYER_DETECTION_PYTHON_SCRIPT_PATH,
			argList
		);
		String resultString = Files.readString(new File(resultFilePathString).toPath());
		log.info("python invoke result string: " + resultString);
		DetectedPlayerData detectedPlayerData = GSON.fromJson(resultString, DetectedPlayerData.class);
		return detectedPlayerData;
	}

	@Override
	public DetectedPlayerData detectPlayersInVideo(String inputVideoFilePathString, String modelFilePathString)
			throws IOException {
		return detectPlayersInVideo(
			inputVideoFilePathString,
			modelFilePathString,
			DEFAULT_MODEL_RESOLUTION
		);
	}

	@Override
	public DetectedPlayerData detectPlayersInVideo(String inputVideoFilePathString, Integer modelResolution)
			throws IOException {
		return detectPlayersInVideo(
			inputVideoFilePathString,
			DEFAULT_MODEL_FILE_PATH_STRING,
			modelResolution
		);
	}

	@Override
	public DetectedPlayerData detectPlayersInVideo(String inputVideoFilePathString) throws IOException {
		return detectPlayersInVideo(
			inputVideoFilePathString,
			DEFAULT_MODEL_FILE_PATH_STRING,
			DEFAULT_MODEL_RESOLUTION
		);
	}
	
}
