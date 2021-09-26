package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        // 1. EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 2. EntityManagerFactory를 통해 EntityManager 생성
        EntityManager em = emf.createEntityManager();
        // 3. EntityManager를 통해 트랜잭션 획득
        EntityTransaction tx = em.getTransaction();

        // 4. 트랜잭션 시작
        tx.begin();

        // 에러 났을 경우를 대비해 try-catch로 처리
        try {
            Team team = new Team();
            team.setName("3팀");
            em.persist(team);

            // 5. 새로 삽입할 Member 객체 생성
            Member member = new Member();
            member.setName("양희찬");
            member.setTeam(team);
            em.persist(member);

            // 8. 트랜잭션 커밋
            tx.commit();

        } catch (Exception e) {
            // 9. 실패하면 롤백!
            System.out.println(e);
            tx.rollback();
        } finally {
            // 10. EntityManagerFactory 및 EntityManager 종료
            em.close();
            emf.close();
        }
    }
}