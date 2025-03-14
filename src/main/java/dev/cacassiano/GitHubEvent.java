
package dev.cacassiano;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

// Classe principal do evento
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubEvent {
    public String id;
    public String type;
    public Actor actor;
    public Repo repo;
    public Payload payload;
    public boolean isPublic;
    public String created_at;
}

// Representa o usuário (Actor)
@JsonIgnoreProperties(ignoreUnknown = true)
class Actor {
    public int id;
    public String login;
    public String display_login;
    public String gravatar_id;
    public String url;
    public String avatar_url;
}

// Representa o repositório
@JsonIgnoreProperties(ignoreUnknown = true)
class Repo {
    public int id;
    public String name;
    public String url;
}

// Representa a estrutura do payload (varia dependendo do tipo de evento)
@JsonIgnoreProperties(ignoreUnknown = true)
class Payload {
    public String action;
    public Issue issue;
    public Comment comment;
    public String ref;
    public String ref_type;
    public String master_branch;
    public String description;
    public String pusher_type;
}

// Representa um issue (chamado dentro de Payload)
@JsonIgnoreProperties(ignoreUnknown = true)
class Issue {
    public String url;
    public String repository_url;
    public String labels_url;
    public String comments_url;
    public String events_url;
    public String html_url;
    public long id;
    public String node_id;
    public int number;
    public String title;
    public User user;
    public List<Label> labels;
    public String state;
    public boolean locked;
    public int comments;
    public String created_at;
    public String updated_at;
    public String closed_at;
    public String author_association;
    public Map<String, Object> sub_issues_summary;
    public String body;
    public Reactions reactions;
}

// Representa um usuário dentro de Issue e Comment
@JsonIgnoreProperties(ignoreUnknown = true)
class User {
    public String login;
    public int id;
    public String node_id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
}

// Representa um rótulo dentro de Issue
@JsonIgnoreProperties(ignoreUnknown = true)
class Label {
    public long id;
    public String node_id;
    public String url;
    public String name;
    public String color;
    public boolean isDefault;
    public String description;
}

// Representa um comentário dentro de Payload
@JsonIgnoreProperties(ignoreUnknown = true)
class Comment {
    public String url;
    public String html_url;
    public String issue_url;
    public long id;
    public String node_id;
    public User user;
    public String created_at;
    public String updated_at;
    public String body;
    public Reactions reactions;
}

// Representa as reações dentro de Issue e Comment
@JsonIgnoreProperties(ignoreUnknown = true)
class Reactions {
    public String url;
    public int total_count;
    public int plus1;
    public int minus1;
    public int laugh;
    public int hooray;
    public int confused;
    public int heart;
    public int rocket;
    public int eyes;
}

