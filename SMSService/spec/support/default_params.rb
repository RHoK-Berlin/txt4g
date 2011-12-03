module Spec
  module Support
    module DefaultParams

      def default_params
        {}
      end unless defined? default_params

      %w(get post put delete head).each do |method|

        define_method method do |action, params = {}, *args|
        super(action, default_params.merge(params), *args)
        end

      end

    end
  end
end
