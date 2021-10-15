he video to see how to deploy angular and spring together

https://www.youtube.com/watch?v=JJoBUdMJf1I


###Docker image
to build, open up the terminal on the root folder and build the image
	docker build -t healthcheck/backend-api .
to rum the image
    docker run --rm -d -p 5001:8080 healthcheck/backend-api
to see the logs
	docker logs -f <containerimage>





#SQL
```sql
    select * from server_description
    select * from health_check
       
    drop table if exists  hrm.server_description
    GO
    create table hrm.server_description(
        id					bigint			not null IDENTITY(1,1),
        current_status		int				null,
        deployment			varchar(255)	null,
        name				varchar(255)	null,
    primary key (id)
    );
    GO
        
    drop table if exists  hrm.health_check
    GO
    create table hrm.health_check(
        id					bigint not		null IDENTITY(1,1),
        artifact_id			varchar(255)	null,
        buildsha			varchar(255)	null,
        created_date_time	datetime		null,
        group_id			varchar(255)	null,
        name				varchar(255)	null,
        response_code		int				null,
        server_id			bigint			null,
        version				varchar(255)	null,
    primary key (id)
    );
    GO
```


SELECT * FROM Hrm.health_check
select * from server_description

INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(1, 1 ,'TALENT', 'TALENT')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(2, 1 ,'ADMIN', 'ADMIN')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(3, 1 ,'PAY', 'ADMIN')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(4, 1 ,'CALENDAR', 'ADMIN')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(5, 1 ,'RECRUITMENT', 'RECRUITMENT')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(6, 1 ,'LEARNING', 'ADMIN')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(7, 1 ,'SOCIAL_FEED', 'SOCIAL_FEED')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(8, 1 ,'CUSTOM_CARDS', 'CUSTOM_CARDS')
INSERT INTO Hrm.server_description(id,current_status,deployment,name)
VALUES(9, 1 ,HRM, HRM)




GO