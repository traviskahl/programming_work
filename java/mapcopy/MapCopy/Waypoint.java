import java.io.File;
import java.util.Formatter;

public class Waypoint {

	private String m_rawData;
	private File m_outputFile;
	private File m_destination;
	private String m_assembledData;

	private String m_id;
	private String m_name;

	private int m_x;
	private int m_y;
	private int m_z;

	private int m_r;
	private int m_g;
	private int m_b;

	private boolean m_isEnabled;
	private String m_dimensions;
	private boolean m_isPersistent;

	public Waypoint(String rawData, File destination) {
		m_rawData = rawData;
		m_isPersistent = true;
		m_dimensions = "";
		m_destination = destination;
	}

	public void getAndSetData() {

		//StringTokenizer st = new StringTokenizer(this.m_rawData, ",");
		String[] rawArray = m_rawData.split("\\,");

		m_name = rawArray[0].substring(5); // start at index 5
		m_x = Integer.parseInt(rawArray[1].substring(2));
		m_z = Integer.parseInt(rawArray[2].substring(2));
		m_y = Integer.parseInt(rawArray[3].substring(2));
		m_isEnabled = Boolean.parseBoolean(rawArray[4].substring(8));

		m_r = (int)(Float.parseFloat(rawArray[5].substring(4)) * 255);
		m_g = (int)(Float.parseFloat(rawArray[6].substring(6)) * 255);
		m_b = (int)(Float.parseFloat(rawArray[7].substring(5)) * 255);

		//String suffix = rawArray[8]; // throwaway
		//String world = rawArray[9]; // also throwaway
		m_dimensions = rawArray[10].substring(11);

		for (int currentChar = 0; currentChar < m_dimensions.length(); ++currentChar) {
			if (m_dimensions.charAt(currentChar) == '#')
				m_dimensions = m_dimensions.replace("#", "");
		}

		m_id = m_name + "_" + m_x + "," + m_y + "," + m_z;

		/*System.out.printf("unique id is: %s\n", m_id);
		System.out.printf("name is: %s\n", m_name);
		System.out.printf("coordinates are: (%d, %d, %d)\n", m_x, m_y, m_z);
		System.out.printf("enabled is %b\n", m_isEnabled);
		System.out.printf("rgb values are: (%.9f, %.9f, %.9f)\n", m_r, m_g, m_b);
		System.out.printf("dimensions are: %s\n", m_dimensions);*/
	}

	public void outputData() {

		// we're just going line by line
		m_assembledData = String.format("{\n");
			m_assembledData += String.format("  \"id\": \"%s\",\n", m_id);
			m_assembledData += String.format("  \"name\": \"%s\",\n", m_name);
			m_assembledData += String.format("  \"icon\": \"waypoint-normal.png\",\n");
			m_assembledData += String.format("  \"x\": %d,\n", m_x);
			m_assembledData += String.format("  \"y\": %d,\n", m_y);
			m_assembledData += String.format("  \"z\": %d,\n", m_z);
			m_assembledData += String.format("  \"r\": %d,\n", m_r);
			m_assembledData += String.format("  \"g\": %d,\n", m_g);
			m_assembledData += String.format("  \"b\": %d,\n", m_b);
			m_assembledData += String.format("  \"enable\": %b,\n", m_isEnabled);
			m_assembledData += String.format("  \"type\": \"Normal\",\n");
			m_assembledData += String.format("  \"origin\": \"MapCopy\",\n");
			m_assembledData += String.format("  \"dimensions\": [\n");

			for (int currentDim = 0; currentDim < m_dimensions.length(); ++currentDim) {
				if (m_dimensions.charAt(currentDim) == '-')
					m_assembledData += String.format("\t%c%c", m_dimensions.charAt(currentDim), m_dimensions.charAt(++currentDim));
				else
					m_assembledData += String.format("\t%c", m_dimensions.charAt(currentDim));

				if (m_dimensions.charAt(currentDim) != m_dimensions.charAt(m_dimensions.length() - 1))
					m_assembledData += ",\n";
				else
					m_assembledData += "\n";
			}

			m_assembledData += String.format("  ],\n");
			m_assembledData += String.format("  \"persistent\": %b\n}", m_isPersistent);

		//System.out.printf("The output should be:\n%s\n", m_assembledData);

		try {
			m_outputFile = new File(m_destination + "/" + m_id + ".json");
			Formatter form = new Formatter(m_outputFile);

			//System.out.printf("Writing into %s\n", m_outputFile.getName());

			form.format(m_assembledData);
			form.close();
		}
		catch (Exception ex) {
			System.err.println("Exception was caught in Waypoint.outputData()");
			ex.printStackTrace();
		}
	}
}
