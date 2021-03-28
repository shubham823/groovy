pipelineJob('seeded') {
  
   parameters {
        stringParam('target_host', '192.168.29.200', 'ip off target_host')
    }
  properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '30')), [$class: 'ScannerJobProperty', doNotScan: false]])
  definition {
    cps {
      script(readFileFromWorkspace('Jenkinsfile'))
      sandbox()     
    }
  }
}
