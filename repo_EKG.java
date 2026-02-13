import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.util.List;

public class RezeptRepository {

    private final Path path;
    private final ObjectMapper mapper = new ObjectMapper();

    public RezeptRepository(Path path) {
        this.path = path;
    }

    public List<Rezept> ladeAlle() throws Exception {
        return mapper.readValue(path.toFile(),
                new TypeReference<List<Rezept>>() {});
    }
}