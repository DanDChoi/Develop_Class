/* 회원 */
DROP TABLE MEMBER CASCADE CONSTRAINTS;
/* 장르 */
DROP TABLE GENRE CASCADE CONSTRAINTS;
/* 취향장르 */
DROP TABLE GENRE_FAVOR CASCADE CONSTRAINTS;
/* 취향배우 */
DROP TABLE ACTOR_FAVOR CASCADE CONSTRAINTS;
/* 취향감독 */
DROP TABLE DIRECTOR_FAVOR CASCADE CONSTRAINTS;
/* 취향소재 */
DROP TABLE MATERIAL_FAVOR CASCADE CONSTRAINTS;
/* 배우 */
DROP TABLE ACTOR CASCADE CONSTRAINTS;
/* 영화 */
DROP TABLE FILM CASCADE CONSTRAINTS;
/* 감독 */
DROP TABLE DIRECTOR CASCADE CONSTRAINTS;
/* 소재 */
DROP TABLE MATERIAL CASCADE CONSTRAINTS;
/* 영화평 */
DROP TABLE FILM_REVIEW CASCADE CONSTRAINTS;
/* 게시판_큐레이팅 */
DROP TABLE CURATING_BOARD CASCADE CONSTRAINTS;

/*DROP SEQUENCE*/
/* 장르 */
DROP SEQUENCE GENRE_SEQ;
/* 배우 */
DROP SEQUENCE ACTOR_SEQ;
/* 감독 */
DROP SEQUENCE DIRECTOR_SEQ;
/* 소재 */
DROP SEQUENCE MATERIAL_SEQ ;
/* 영화 */
DROP SEQUENCE FILM_SEQ ;
/* 영화평 */
DROP SEQUENCE REVIEW_SEQ;
/* 게시판_큐레이팅 */
DROP SEQUENCE CURATING_SEQ;

commit;