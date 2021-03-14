pipelineJob('seeded') {
  definition {
    cps {
      script(readFileFromWorkspace('Jenkinsfile'))
      sandbox()     
    }
  }
}
