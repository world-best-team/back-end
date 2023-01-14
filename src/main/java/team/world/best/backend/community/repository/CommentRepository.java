package team.world.best.backend.community.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.world.best.backend.community.domain.Comment;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public Long save(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }

    public Comment findById(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> findAll() {
        return null;
    }

    public List<Comment> findByPostId(Long postId) {
        return em.createQuery(
                "select c from Comment c" +
                        " join c.post p" +
                        " where p.id = : postId",
                Comment.class
        )
                .setParameter("postId", postId)
                .getResultList();
    }

}
