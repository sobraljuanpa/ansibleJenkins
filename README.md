# Final project

## Objectives
This is the final project for an automation course, and the goal is to bring together as many of the concepts seen within it as possible.

This is the list of things done so far:

+ Created an ansible playbook to run locally on the host which will be running the tests, so as to install all dependencies and configure a Jenkins instance on it.

+ Managed to hook up Jenkins with this Github repo, Jenkins periodically polls it and if there are any changes it triggers a job.