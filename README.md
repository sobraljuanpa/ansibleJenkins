# About this project

## Ansible playbooks

There are two playbooks in this project; one to configure a server running a debian based distribution as a Jenkins server, and another one to configure a server running a debian based distribution to run selenium tests.

## Groovy script

The groovy file you will find inside the jenkins folder describes a pipeline. Jenkins handles two types of pipeline syntax: scripted pipeline and declarative pipeline. In this particular instance it was a matter of personal preference to use the scripted pipeline but it presents a couple of advantages over the declarative one, particularly the possibility of leveraging java's standard library.

This pipeline:

1. Periodically polls the configured repository for changes, and triggers an execution in case of finding any.

2. Runs all tests on the updated code using maven.

3. Generates an Allure report regardless of the build status. This is really important since failing test cases would cause the step not to be executed.

4. Notifies configured recipients via mail, and attaches a json which contains information on the latest run's results.

## Jenkins configuration

In order to get all of this working together, there are a number of manual Jenkins configuration steps which we cannot skip.

First we need to install and configure the Jenkins Allure plugin, which is detailed in [their documentation](https://docs.qameta.io/allure/#_jenkin).

Then we have to configure the ext email plugin which we use in order to send our notifications.

After all this is achieved, we just need to create a new pipeline and paste the groovy code into the box at the bottom of the form.

# Installing our Jenkins server
So, you read the post and wanted to do a little POC to see for yourself how this stack worked together, or maybe just want to try the playbooks. Here you are gonna learn how!

# Running the ansible playbooks
There are two playbooks in this project, the first one takes care of the Jenkins installation and the second one sets it up to run headless Selenium tests.

The only requirement is that the server's distribution is Debian based(eg: Ubuntu) and that you have ansible previously installed. In case you haven't, you just need to open your terminal and execute the following command:
```
sudo apt install ansible
```

After you have ansible, you need to clone the repository. If you haven't got git installed, now is the time to do it executing this command:

```
sudo apt install git
```
Now we are all set!

Execute the following command in order to clone the repository:
``` sh
git clone $repositoryURL
```

Then, move into the directory which contains the playbooks:
```
cd $playbookDirectory
```

And run the playbook with the following command:
``` sh
ansible-playbook $playbook.yml --ask-become-pass
```

You should see an output similar to the following one:

ACA VA UNA FOTO, VOY A TENER QUE LEVANTAR UN SERVER NUEVO PARA CHIVIAR Y DEJAR TODO ESTO ANDANDO MUY BONITO Y TESTEADO

Once this is done, you can log into Jenkins using the password you just got