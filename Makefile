start:
	\
	docker pull selenoid/vnc:chrome_84.0 && \
	docker-compose up -d --force-recreate
stop:
	\
	docker-compose down --rmi all && \
	docker rmi selenoid/vnc:chrome_84.0
test:
	\
	./gradlew clean -Plaunch=remote -Pthread=5 testChrome