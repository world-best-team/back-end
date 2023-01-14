package team.world.best.backend.community.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.world.best.backend.community.domain.Post;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    public Long save(Post post) {
        em.persist(post);
        return post.getId();
    }

    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

}
