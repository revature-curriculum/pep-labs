require 'pry'
require 'fileutils'

module Codelabs
end

require_relative 'codelabs/base'

class Codelabs::Runner
  def initialize(args)
    @args = args
  end

  def run
    puts "Running Codelabs Runner"
    # convert the first element in @args to a ruby constantentifier
    # and instantiate it, then call the run method on it
    Codelabs.const_get(@args[0].capitalize).new.run
  end
  
end

Codelabs::Runner.new(ARGV).run