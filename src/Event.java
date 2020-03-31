import java.io.Serializable;

    public class Event implements Serializable {
        private long timestamp;
        private String description;

        public Event(long timestamp, String description) {
            this.timestamp = timestamp;
            this.description = description;
        }

        public String toString() {
            return "Event [timestamp= " + timestamp + ", description= " + description
                    + "]";
        }
    }


