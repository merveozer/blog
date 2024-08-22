BEGIN;

CREATE TABLE IF NOT EXISTS public.blogs
(
    blog_id bigint NOT NULL,
    user_id bigint,
    CONSTRAINT blogs_pkey PRIMARY KEY (blog_id),
    CONSTRAINT uk_c4kfnl4bgtgmkmhnb1yxrmi23 UNIQUE (user_id),
    CONSTRAINT fkpg4damav6db6a6fh5peylcni5 FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.posts
(
    post_id bigint NOT NULL,
    text character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    blog_id bigint,
    CONSTRAINT posts_pkey PRIMARY KEY (post_id),
    CONSTRAINT fk46hamw7vkqcug68icapbki4v2 FOREIGN KEY (blog_id)
        REFERENCES public.blogs (blog_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.tags
(
    tag_id integer NOT NULL,
    code bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT tags_pkey PRIMARY KEY (tag_id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    user_id bigint NOT NULL,
    password character varying(255) COLLATE pg_catalog."default",
    user_name character varying(255) COLLATE pg_catalog."default",
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);


COMMIT;