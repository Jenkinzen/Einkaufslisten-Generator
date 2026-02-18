package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.util.List;
import model.Rezept;

public class repo_EKG {

    private final Path path;
    private final ObjectMapper mapper = new ObjectMapper();

    public repo_EKG(Path path) {
        this.path = path;
    }

    public List<Rezept> ladeAlle() throws Exception {
        return mapper.readValue(path.toFile(),
                new TypeReference<List<Rezept>>() {});
    }
}
