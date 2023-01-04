# Deployments

The deployment configuration is created using helm package manager and update couple of things line environment variables and config-map, volume mounts etc

Steps to configure the helm package manager to trade application

Step 1: Navigate to deployments folder through command prompt

Step 2: create the deployment configuration using the command ```helm create trade-data-feeder-helm```

Step 3: Run ```helm install trade-data-feeder-helm --dry-run .``` to see how the deployment configs will looks like, Before deploying

Step 4: In Values.yaml update the image name from "nginx" to "merugu/trade-data-feeder-helm:latest"

Step 5: makesure to address the environment variable passed to container image, Usually you need to create secrets folder and upload your api key their
        Note: Secret should be stored in HashCorp value or AWS parameter store

Step 5: In deployment.yaml file we are using the container port value as "{{ .Values.service.port }}". Let's update the port number "80" to "8080" in values.yaml
        at "service.port" value

Step 6: package all the config deployment.yaml, service.yaml, secret.yaml etc by using ```helm package .``` from the directory where we have Charts.yaml

Step 7: Install in kubernetes using kubectl commad ```helm install trade-data-feeder-helm $PATH/trade-data-feeder-helm-0.1.0.tgz```

where $PATH is absoulte path we got from the command ```helm package .``` 

