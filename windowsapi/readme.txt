FolderMaker_Main is a class written to check the code in plain java.

FolderMaker is the class with the service. mkdir takes a folder name as input and creates a folder in pwd;

pwd is set in SystemEnvironment class; Its abstracted up as it can be set once and the subsequent calls to the api need not send the folder and/or environment specific information.

SystemEnvironment can be Used to configure any environment related activities that will then be available in creatfolder, runexecutable and future classes. 


In system environment, System variables are scanned for default path in the order of 1.tmp 2.temp and 3.userprofile and a default path is set up

Its possible to set a different value to the pwd using setpwd();

Also if a name of the folder already existed in the path, we added an integer and created a folder under that path

FileDownloader_URL will download the file from the url. It expects just a valid url as input and the file will be downloaded to pwd. 